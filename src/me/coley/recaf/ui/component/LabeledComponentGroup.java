package me.coley.recaf.ui.component;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * A group of radio-buttons that handles singular radio selection.
 * 
 * @author Matt
 */
@SuppressWarnings("serial")
public class LabeledComponentGroup extends JPanel {
	private final GridBagConstraints c = new GridBagConstraints();

	public LabeledComponentGroup(LabeledComponent... components) {
		setLayout(new GridBagLayout());
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1.0;
		c.weighty = 1.0;
		c.gridy = 1;
		c.gridwidth = 1;
		for (LabeledComponent comp : components) {
			add(comp);
		}
	}

	/**
	 * Overridden to prevent adding components the default way.
	 */
	@Override
	public Component add(Component comp) throws RuntimeException {
		if (comp instanceof LabeledComponent) {
			LabeledComponent lc = (LabeledComponent) comp;
			c.gridx = 0;
			super.add(lc.getLabel(), c);
			c.gridx = 1;
			super.add(lc.getComponent(), c);
			c.gridy += 1;
			return comp;
		} else {
			c.gridx = 0;
			super.add(new JLabel(""), c);
			c.gridx = 1;
			super.add(comp, c);
			c.gridy += 1;
			return comp;
		}
	}
}