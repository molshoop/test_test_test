package nl.gerete.generator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:marc.mol@bloomville.nl">Marc Mol</a>
 * Created on 11-05-2021.
 */
public class GenerateScreen {

	private File directory;

	public static void main(String[] args) {
		GenerateScreen generateScreen = new GenerateScreen();
		if (!generateScreen.aeArgumentsOk(args)) {
			throw new IllegalStateException("Kan iets niet doen");
		}
		try {
			List<IScreenDefinition> screens = new ArrayList<>();
			screens.add(new FirstScreenDefinition());
			screens.add(new SecondScreenDefinition());
			generateScreen.generateHelloWorld(args[0], screens);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private boolean aeArgumentsOk(String[] args) {

		if (args.length != 1) {
			throw new IllegalArgumentException("Geef de directory op waar alles aangemaakt moet worden.");
		}
		directory = new File(args[0]);
		if (directory.exists() && directory.canWrite())
			return true;

		return false;
	}

	private void generateHelloWorld(String arg, List<IScreenDefinition> screens) throws IOException {

		for(IScreenDefinition screen : screens) {
			BufferedWriter writer = new BufferedWriter(new FileWriter(arg + "/" + screen.getScreenName() + ".php"));

			writer.write("<!-- Generated by Marc's very sophisticated PHP generator, so keep off -->\n");

			writer.write("<html>\n");
			writer.write("<head>\n");

			addTitle(writer, screen.getTitle());
			addBody(writer, screen);

			writer.write("</head>\n");
			writer.write("</html>\n");

			writer.close();
		}
	}

	private void addBody(BufferedWriter writer, IScreenDefinition screen) throws IOException {
		writer.write("<body>\n");
		if(screen.getScreenType() == ScreenType.EDIT) {
			generateForm(writer, screen);
		}
//		addPHPStart(writer);
//		addCode(writer);
//		addPHPEnd(writer);
		writer.write("</body>\n");
	}

	private void generateForm(BufferedWriter writer, IScreenDefinition screen) throws IOException {
		writer.write("<form action=\"" + screen.getScreenName() + ".php\" method=\"post\">\n");
		for (FieldDefinition definition : screen.getFields()) {
			writer.write("<label for=\""+definition.getName()+"\">"+ definition.getLabel() + ":</label><br>\n");
			writer.write("<input type=\""+definition.getFieldType().name()+"\" name=\"" + definition.getName() + "\"><br>\n");
		}
		writer.write("</form>\n");
	}

	private void addCode(BufferedWriter writer) throws IOException {
		writer.write("echo \"Hello Chris!\"");
	}

	private void addPHPStart(BufferedWriter writer) throws IOException {
		writer.write("<?php \n");
	}

	private void addPHPEnd(BufferedWriter writer) throws IOException {
		writer.write(" ?>\n");
	}

	private void addTitle(BufferedWriter writer, String title) throws IOException {
		writer.write("<title>");
		writer.write(title);
		writer.write("</title>\n");

	}
}