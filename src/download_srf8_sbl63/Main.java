package download_srf8_sbl63;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		
		String file_directory = "C:\\Users\\Leandro\\Documents\\teste\\";
		String old_file_name = "TI8.png";
		String new_file_name = "TI8.png";
	    String file_name_and_directory = "C:\\Users\\Leandro\\Documents\\teste\\TI8.zip";
	    String file_name_and_directory_download = "C:\\Users\\Leandro\\Documents\\teste\\TI8555.png";
	    String name_file = "mothers-day-2018-6361329190305792-l.png";
		
        Dates_Hours mes = new Dates_Hours();
        mes.MonthUpdated();
        System.out.println(mes.MonthUpdated() + " - " + mes.year_updated);
        
    	Arquivo file = new Arquivo();
    	file.DownloadFile(name_file, file_name_and_directory_download);
    	file.unZipIt(file_name_and_directory, file_directory);
    	file.RenameFile(file_directory + old_file_name, file_directory + new_file_name);
        
    }
	
	
}
