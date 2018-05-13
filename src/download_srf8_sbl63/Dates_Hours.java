package download_srf8_sbl63;

import java.time.Year;
import java.util.Calendar;

public class Dates_Hours {
	int year_updated = Year.now().getValue();
	int num_month_updated = Calendar.getInstance().get(Calendar.MONTH);

	public String MonthUpdated() {
        String[] name_month = {"Janeiro", "Fevereiro", "Marco", "Abril", "Maio", "Junho", 
        			"Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
        //pega o nome do mes atual
        String month_updated = name_month[num_month_updated];
        return month_updated;
	}
}
