package com.abhik;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Robot;

public class StopSleeping {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Awake! :)");
		int stopAfterInSec = 200;
		int smoothScrollValue = 1;
		try {
			int xCoord = 0;
			int yCoord = 0;
			int moveDist = smoothScrollValue;
			Robot robot = new Robot();
			boolean leftToRight = true;
			boolean upToDown = true;
			long start = System.currentTimeMillis();
			while (true) {
				// System.out.printf("(%d, %d)", xCoord, yCoord);
				// System.out.println();
				long end = System.currentTimeMillis();
				// System.out.println(end-start);
				// if((end - start)/1000 > stopAfterInSec) break;
				if (xCoord > 1270 || xCoord < 0) {
					leftToRight = !leftToRight;
					if (upToDown) {
						yCoord += moveDist;
					} else
						yCoord -= moveDist;
				}
				if (yCoord > 720 || yCoord < 0) {
					upToDown = !upToDown;
					if (upToDown) {
						yCoord += moveDist;
					} else
						yCoord -= moveDist;
				}
				if (leftToRight) {
					xCoord += moveDist;
				} else
					xCoord -= moveDist;
				robot.mouseMove(xCoord, yCoord);
				robot.delay(moveDist >= 100 ? 50 : 10);
				if (MouseInfo.getPointerInfo().getLocation().getY() - yCoord > moveDist % 500) {
					System.out.println("Will Sleep Soon!!! zZzZ");
					System.exit(0);
				}
			}
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
}