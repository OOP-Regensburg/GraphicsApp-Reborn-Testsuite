package BouncerDemo;

import de.ur.mi.bouncer.apps.BouncerApp;
import de.ur.mi.bouncer.world.fields.FieldColor;
import de.ur.mi.oop.launcher.GraphicsAppLauncher;

public class DieStrasse extends BouncerApp {


	@Override
	public void bounce() {
		loadMap("Strasse");
		repairField();
		while (bouncer.canMoveForward()) {
				repairField();
				bouncer.move();
		}
	}

	private void repairField() {
		if(bouncer.isOnFieldWithColor(FieldColor.RED)) {
			bouncer.paintField(FieldColor.GREEN);
		}
	}

	public static void main(String[] args) {
		GraphicsAppLauncher.launch("DieStrasse");
	}

}
