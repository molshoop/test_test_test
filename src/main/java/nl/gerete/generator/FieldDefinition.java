package nl.gerete.generator;

/**
 * @author <a href="mailto:marc.mol@bloomville.nl">Marc Mol</a>
 * Created on 20-05-2021.
 */
public class FieldDefinition {

	private String m_name;

	private String m_label;

	private FieldType m_fieldType;

	private int m_length;

	public FieldDefinition(String name, String label, FieldType fieldType) {
		m_name = name;
		m_label = label;
		m_fieldType = fieldType;
		m_length = 0;
	}

	public FieldDefinition(String name, String label, FieldType fieldType, int length) {
		m_name = name;
		m_label = label;
		m_fieldType = fieldType;
		m_length = length;
	}

	public String getName() {
		return m_name;
	}

	public String getLabel() {
		return m_label;
	}

	public FieldType getFieldType() {
		return m_fieldType;
	}

	public int getLength() {
		return m_length;
	}
}
