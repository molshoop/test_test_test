package nl.DevHaven.Generator;

import java.io.*;

/**
 * @author <a href="mailto:christiaan.schop@itris.nl">Christiaan Schop (Team VW)</a>
 * @since 11-5-21.
 */
public class AngularGen {

	static final String HELLO = "Hello Worlds \n ";

	static final String APP_COMPONENT = "app.component.html";

	static final String PATH = "/home/christiaan/git/registratieProject/src/app";

	public static void main(String[] args) throws IOException {
		AngularGen generator = new AngularGen();
		File file = generator.createFile(APP_COMPONENT);

		FileWriter writer = new FileWriter(file);
		BufferedWriter buffWriter = new BufferedWriter(writer);
		generator.addStringInput(buffWriter);
		generator.addCheckbox(buffWriter);
		generator.addParagraphWithId(buffWriter, "para", "This text will be changed by button");
		generator.addButtonWithFunction(buffWriter, "Button", "name");
		generator.addLineToFile(buffWriter, "<router-outlet></router-outlet>");
		buffWriter.close();

		//
		BufferedWriter testComponent = generator.openNewAngularComponent("app");
		generator.addFunctionToComponent(testComponent);
		generator.finalizeAngularComponent(testComponent);

		generator.readFile(file);
	}

	private void readFile(File file) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = br.readLine();
		while(line != null){
			System.out.println(line);
			line = br.readLine();
		}
	}

	private void addLineToFile(BufferedWriter buffWriter, String line) throws IOException {
		buffWriter.write(line);
		buffWriter.newLine();
	}

	private File createFile(String fileName){
		return new File(PATH, fileName);
	}

	private void addStringInput(BufferedWriter buffWriter) throws IOException {
		String line = "<input type=\"text\" id=\"fname\" name=\"fname\" value=\"John\"><br>";
		addLineToFile(buffWriter, line);
	}

	private void addCheckbox(BufferedWriter buffWriter) throws IOException {
		String line = "<input type=\"checkbox\" id=\"checkbox1\" name=\"checkbox1\" value=\"checkbox\">";
		addLineToFile(buffWriter, line);
	}

	private void addParagraphWithId(BufferedWriter buffWriter, String elementId, String content) throws IOException {
		String line = "<p id=\""+ elementId + "\">" + content + "</p>";
		addLineToFile(buffWriter, line);
	}

	private void addButtonWithFunction(BufferedWriter buffWriter, String buttonName, String functionName) throws IOException {
		String line = "<input type=\"button\" (click)=\"" + functionName + "()\" value=\"" + buttonName + "\">";
		addLineToFile(buffWriter, line);
	}

	private BufferedWriter openNewAngularComponent(String componentName) throws IOException {
		File file = createFile(componentName + ".component.ts");
		FileWriter fileWriter = new FileWriter(file);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		bufferedWriter.write("import { Component } from '@angular/core';");
		bufferedWriter.newLine();
		bufferedWriter.newLine();
		bufferedWriter.write("@Component({");
		bufferedWriter.newLine();
		bufferedWriter.write("selector: '"+ componentName + "',");
		bufferedWriter.newLine();
		bufferedWriter.write("templateUrl: './"+ componentName + ".component.html',");
		bufferedWriter.newLine();
		bufferedWriter.write("styleUrls: ['./"+ componentName + ".component.css']");
		bufferedWriter.newLine();
		bufferedWriter.write("})");
		bufferedWriter.newLine();
		String uppercaseComponentName = componentName.substring(0,1).toUpperCase() + componentName.substring(1);
		bufferedWriter.write("export class "+ uppercaseComponentName + "Component {");
		bufferedWriter.newLine();

		return bufferedWriter;
	}

	private void addFunctionToComponent(BufferedWriter bw) throws IOException {
		bw.newLine();
		bw.write("public counter : number = 0;");
		bw.newLine();
		bw.write("increment(){ this.counter += 1; }");
		bw.newLine();
		bw.write("public name() {");
		bw.newLine();
		bw.write("document.getElementById(\"para\").innerHTML = \"I now like this paragraph! times \" + this.counter;");
		bw.newLine();
		bw.write("this.increment();");
		bw.newLine();
		bw.write("}");
		bw.newLine();
	}

	private void finalizeAngularComponent(BufferedWriter bw) throws IOException {
		bw.write("}");
		bw.close();
	}
}

