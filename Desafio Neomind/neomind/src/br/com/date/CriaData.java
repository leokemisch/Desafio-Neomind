package br.com.date;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;


public class CriaData {

	public static GregorianCalendar retornaHorario(int hr, int min) {

		GregorianCalendar horario = new GregorianCalendar(2010, 02, 4, hr, min, 10);
		SimpleDateFormat sd = new SimpleDateFormat("dd/MMM/yyyy HH:mm:ss");
		System.out.println(sd.format(horario.getTime()));

		return horario;

	}

}
