package download_srf8_sbl63;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Arquivo {
	String url_srf_ti8 = "https://www.google.com//logos/doodles/";
	public Dates_Hours dates_hours = new Dates_Hours();
	private int year_updated = dates_hours.year_updated;

	public void DownloadFile(String file_name_download, String file_name_and_directory) throws IOException {

		URL url = new URL( url_srf_ti8 + year_updated + "/" + file_name_download);
		File file = new File(file_name_and_directory);

		InputStream is = url.openStream();
		FileOutputStream fos = new FileOutputStream(file);

		int bytes = 0;

		while ((bytes = is.read()) != -1) {
			fos.write(bytes);
		}
		is.close();
		fos.close();
	}

	public void RenameFile(String old_name_archieve, String new_name_archieve) {

		File oldfile = new File(old_name_archieve);
		File newfile = new File(new_name_archieve);

		if (oldfile.renameTo(newfile)) {
			System.out.println("Rename succesful");
		} else {
			System.out.println("Rename failed");
		}
	}

	public void unZipIt(String zipFile, String outputFolder) {

		//List<String> fileList;

		byte[] buffer = new byte[1024];

		try {
			// create output directory is not exists
			File folder = new File(outputFolder);
			if (!folder.exists()) {
				folder.mkdir();
			}

			// get the zip file content
			ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile));
			// get the zipped file list entry
			ZipEntry ze = zis.getNextEntry();

			while (ze != null) {

				String fileName = ze.getName();
				
				File newFile = new File(outputFolder + File.separator + fileName);

				System.out.println("file unzip : " + newFile.getAbsoluteFile());

				// create all non exists folders
				// else you will hit FileNotFoundException for compressed folder
				new File(newFile.getParent()).mkdirs();

				FileOutputStream fos = new FileOutputStream(newFile);

				int len;
				while ((len = zis.read(buffer)) > 0) {
					fos.write(buffer, 0, len);
				}
				fos.close();
				ze = zis.getNextEntry();
			}
			zis.closeEntry();
			zis.close();

			System.out.println("Done");

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
