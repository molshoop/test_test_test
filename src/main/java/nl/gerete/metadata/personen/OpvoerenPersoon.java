package nl.gerete.metadata.personen;

import nl.gerete.generator.FieldDefinition;
import nl.gerete.generator.FieldType;
import nl.gerete.generator.IScreenDefinition;
import nl.gerete.generator.ScreenType;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:marc.mol@bloomville.nl">Marc Mol</a>
 * Created on 20-05-2021.
 */
public class OpvoerenPersoon implements IScreenDefinition {

	@Override public String getScreenName() {
		return "Scherm0";
	}

	@Override
	public String getTitle() {
		return "Eerste scherm probeersel";
	}

	public List<FieldDefinition> getFields() {
		List<FieldDefinition> fields = new ArrayList<>();
		fields.add(new FieldDefinition("firstName", "First name", FieldType.string, 22));
		fields.add(new FieldDefinition("lastName", "Last name", FieldType.date));
		fields.add(new FieldDefinition("gender", "Gender", FieldType.email));
		fields.add(new FieldDefinition("email", "Email", FieldType.email));
		return fields;
	}

	public ScreenType getScreenType() {
		return ScreenType.EDIT;
	}
}
