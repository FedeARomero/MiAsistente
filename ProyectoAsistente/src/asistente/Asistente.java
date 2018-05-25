package asistente;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import conversor.Conversor;

public class Asistente {
	private String nombre;

	public Asistente(String nombre) {
		this.nombre = nombre;
	}

	public String escuchar(String mensaje) {

		final String regex = "(@" + this.nombre + ")(?: cuántos | cuántas )(\\w+|\\w+ \\w+)(?: son )(\\d+) (\\w+ \\w+|\\w+)";
		final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
		final Matcher matcher = pattern.matcher(mensaje);

		if (matcher.find()) {
			
			return new Conversor().convertir(matcher.group(3), matcher.group(4), matcher.group(2));
		}

		return "Disculpa... no entiendo el pedido, @delucas ¿podrías repetirlo?";
	}
}
