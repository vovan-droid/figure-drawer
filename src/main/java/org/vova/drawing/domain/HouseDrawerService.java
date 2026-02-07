package org.vova.drawing.domain;

import org.vova.drawing.core.PatternDrawerService;
import org.vova.drawing.core.BaseDrawer;

import static org.vova.drawing.core.PatternDrawerService.dot;
import static org.vova.drawing.core.PatternDrawerService.point;

public class HouseDrawerService extends BaseDrawer<HouseDrawerService> {

    private HouseDrawerService() {
    }

    public static HouseDrawerService newInstance() {
        return new HouseDrawerService();
    }

    public HouseDrawerService drawHouseLvl4(int size) {
        int center = size / 2;
        checkMinSize(size, 3);
        ensureOdd(size);

        // Business logic code
        createPatternDrawer()
                .printDottedLinesEx(center, point(center, -1), point(center, 1))
                .printSolidLine(size)
                .printDottedLinesEx(size - 2, point(0, 0), point(1, 1), point(size - 2, -1), point(size - 1, 0))
                .printSolidLine(size);
        return this;
    }

    public HouseDrawerService drawHouseLvl3(int size) {
        int midHeight = size / 2 - 1;
        checkMinSize(size, 3);
        ensureOdd(size);

        // Business logic code
        createPatternDrawer()
                .printDottedLine(midHeight + 1)
                .printDottedLines(midHeight, dot(midHeight, -1), dot(1, 2))
                .printSolidLine(size)
                .printDottedLines(midHeight, dot(0, 0), dot(0, 1), dot(size - 4, -2), dot(0, 1))
                .printDottedLines(1, dot(0, 0), dot(midHeight, 0), dot(midHeight, 0))
                .printDottedLines(midHeight, dot(0, 0), dot(midHeight - 1, -1), dot(1, 2), dot(midHeight - 1, -1))
                .printSolidLine(size);
        return this;
    }

    public HouseDrawerService drawHouseLvl2(int size) {
        checkMinSize(size, 3);
        ensureOdd(size);
        PatternDrawerService pattern = createPatternDrawer();
        int midHeight = size / 2 - 1;

        // Business logic code
        pattern.printDottedLine(midHeight + 1);
        for (int i = 0; i < midHeight; i++) {
            pattern.printDottedLine(midHeight - i, 2 * i + 1);
        }
        pattern.printSolidLine(size);
        for (int i = 0; i < midHeight; i++) {
            pattern.printDottedLine(0, i, size - 4 - 2 * i, i);
        }
        pattern.printDottedLine(0, midHeight, midHeight);
        for (int i = 0; i < midHeight; i++) {
            pattern.printDottedLine(0, midHeight - 1 - i, 1 + 2 * i, midHeight - 1 - i);
        }
        pattern.printSolidLine(size);
        return this;
    }

    public HouseDrawerService drawHouseLvl1(int size) {
        if (size < 3) {
            throw new IllegalArgumentException("Size must be at least 3");
        }
        if (size % 2 == 0) {
            throw new IllegalArgumentException("Size must be odd");
        }
        int midHeight = size / 2 - 1;

        // Business logic code
        for (int i = 0; i <= midHeight; i++) {
            System.out.print(" ");
        }
        System.out.println("*");
        for (int i = 0; i < midHeight; i++) {
            for (int j = 0; j < midHeight - i; j++) {
                System.out.print(" ");
            }
            System.out.print("*");
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print(" ");
            }
            System.out.println("*");
        }
        for (int i = 0; i < size; i++) {
            System.out.print("*");
        }
        System.out.println();
        for (int i = 0; i < midHeight; i++) {
            System.out.print("*");
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            System.out.print("*");
            for (int j = 0; j < size - 4 - 2 * i; j++) {
                System.out.print(" ");
            }
            System.out.print("*");
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            System.out.println("*");
        }
        System.out.print("*");
        for (int i = 0; i < midHeight; i++) {
            System.out.print(" ");
        }
        System.out.print("*");
        for (int i = 0; i < midHeight; i++) {
            System.out.print(" ");
        }
        System.out.println("*");
        for (int i = midHeight - 1; i >= 0; i--) {
            System.out.print("*");
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            System.out.print("*");
            for (int j = 0; j < size - 4 - 2 * i; j++) {
                System.out.print(" ");
            }
            System.out.print("*");
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            System.out.println("*");
        }
        for (int i = 0; i < size; i++) {
            System.out.print("*");
        }
        System.out.println();
        return this;
    }
}
