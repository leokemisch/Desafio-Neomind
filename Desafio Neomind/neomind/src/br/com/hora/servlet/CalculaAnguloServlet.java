package br.com.hora.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;

import br.com.date.CriaData;
import br.com.hora.objeto.Relogio;

import java.io.IOException;
import java.util.GregorianCalendar;
import java.io.PrintWriter;
import javax.servlet.ServletException;

public class CalculaAnguloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public long retornaAnguloRelogio(GregorianCalendar horario) {

		int hora = horario.get(Calendar.HOUR_OF_DAY);
		int minuto = horario.get(Calendar.MINUTE);
		long ang = ((60 * hora) - (11 * minuto)) / 2;
		if (ang < 0) {
			ang = ang * (-1);
		} 
		return ang;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String hr = request.getParameter("hora");
		String min = request.getParameter("min");

		Relogio relogio = new Relogio();
		relogio.setHr(Integer.parseInt(hr));
		relogio.setMin(Integer.parseInt(min));

		long resposta = retornaAnguloRelogio(CriaData.retornaHorario(relogio.getHr(), relogio.getMin()));

		PrintWriter out = response.getWriter();
		out.print("O ponteiro das horas encontra-se a " + resposta + "º de distancia do ponteiro dos minutos");

	}
}
