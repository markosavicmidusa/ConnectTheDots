package paint;

import java.io.File;

public class ConnectTheDots {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		if (args.length != 1) {
			System.out.println("ERROR: missing argument fileName (args[0]), Try again ....");
			System.exit(1);
		}

		String fileName = args[0];

		File model = new File(fileName);

		System.out.println("INPUT:");
		System.out.println();
		
		Painter painter = new Painter(model, "*", " ");
		painter.paintPicture();
		
		System.out.println("----------------------------------------");
		System.out.println("OUTPUT:");
		System.out.println();
		
		painter.getPaper().printPicture();

	}
}
