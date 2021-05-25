package nl.gerete.generator;

import java.util.List;

/**
 * Interface for the definition of screens.
 *
 * @author <a href="mailto:marc.mol@bloomville.nl">Marc Mol</a>
 * Created on 20-05-2021.
 */
public interface IScreenDefinition {

	String getScreenName();

	String getTitle();

	List<FieldDefinition> getFields();

	ScreenType getScreenType();
}
