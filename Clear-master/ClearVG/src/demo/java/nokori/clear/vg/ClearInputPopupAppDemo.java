package nokori.clear.vg;

import nokori.clear.vg.apps.ClearInputApp;
import nokori.clear.vg.widget.assembly.WidgetAssembly;
import nokori.clear.windows.GLFWException;
import nokori.clear.windows.Window;
import nokori.clear.windows.WindowManager;
import nokori.clear.windows.util.TinyFileDialog;

import java.io.File;

public class ClearInputPopupAppDemo extends ClearHelloWorldDemo {

	public static void main(String[] args) {
		ClearApp.launch(new ClearInputPopupAppDemo(), args);
	}

	@Override
	public void init(WindowManager windowManager, Window window, NanoVGContext context, WidgetAssembly rootWidgetAssembly, String[] args) {
		super.init(windowManager, window, context, rootWidgetAssembly, args);
		
		button.setOnMouseButtonEvent(e -> {
			if (button.isMouseWithin() && e.isPressed()) {
				
				try {
					
					new ClearInputApp(this, 300, 200, ClearColor.BABY_BLUE, new File("fonts/NotoSans/"),
							"Input Window Demo",
							"Input something here.\n\nThis is a new line.\nNew lines should offset the input box...",
							"Default text") {

						@Override
						protected void confirmButtonPressed(String text) {
							TinyFileDialog.showMessageDialog("ClearInputWindow Text Confirmed", text, TinyFileDialog.Icon.INFORMATION);
						}
					}.show();
					
				} catch (GLFWException e1) {
					e1.printStackTrace();
				}
			}
		});
	}
}
