package nl.gerete.generator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:marc.mol@bloomville.nl">Marc Mol</a>
 * Created on 20-05-2021.
 */
public class SecondScreenDefinition implements IScreenDefinition {

	@Override public String getScreenName() {
		return "scherm1";
	}

	@Override
	public String getTitle() {
		return "Tweede scherm probeersel";
	}

	public List<FieldDefinition> getFields() {
		List<FieldDefinition> fields = new ArrayList<>();
		fields.add(new FieldDefinition("veld1", "Veld 1", FieldType.string, 2));
		fields.add(new FieldDefinition("veld2", "Veld 2", FieldType.file));
		fields.add(new FieldDefinition("veld3", "Veld 3", FieldType.checkbox));
		return fields;
	}

	public ScreenType getScreenType() {
		return ScreenType.EDIT;
	}
}
