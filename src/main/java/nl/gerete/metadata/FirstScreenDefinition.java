package nl.gerete.metadata;

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
public class FirstScreenDefinition implements IScreenDefinition {

	@Override public String getScreenName() {
		return "Scherm0";
	}

	@Override
	public String getTitle() {
		return "Eerste scherm probeersel";
	}

	public List<FieldDefinition> getFields() {
		List<FieldDefinition> fields = new ArrayList<>();
		fields.add(new FieldDefinition("veld1", "Veld 1", FieldType.string, 22));
		fields.add(new FieldDefinition("veld2", "Veld 2", FieldType.date));
		fields.add(new FieldDefinition("veld3", "Veld 3", FieldType.email));
		return fields;
	}

	public ScreenType getScreenType() {
		return ScreenType.EDIT;
	}
}
