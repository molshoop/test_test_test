package nl.gerete.generator;

/**
 * @author <a href="mailto:marc.mol@bloomville.nl">Marc Mol</a>
 * Created on 20-05-2021.
 */
public enum FieldType {

	button("button"),
	checkbox("checkbox"),
	color("color"),
	date("date"),
	datetime("datetime-local"),
	email("email"),
	file("file"),
	hidden("hidden"),
	image("image"),
	month("month"),
	number("number"),
	password("password"),
	radio("radio"),
	range("range"),
	reset("reset"),
	search("search"),
	submit("submit"),
	tel("tel"),
	text("text"),
	time("time"),
	url("url"),
	week("week");

	public final String label;

	private FieldType(String label) {
		this.label = label;
	}
}
