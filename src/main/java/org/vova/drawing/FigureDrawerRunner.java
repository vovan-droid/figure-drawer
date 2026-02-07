package org.vova.drawing;

import org.vova.drawing.domain.FigureDrawerService;
import org.vova.drawing.domain.HouseDrawerService;

public class FigureDrawerRunner {

    public static void main(String[] args) {
        int size = 7;

        // Drawing different figures, with an empty line between them
        FigureDrawerService.newInstance()
                .drawHorizontalLine(size)
                .drawNewLine()
                .drawVerticalLine(size)
                .drawNewLine()
                .drawSquareLvl1(size)
                .drawNewLine()
                .drawSquareLvl2(size)
                .drawNewLine()
                .drawTriangle1Lvl1(size)
                .drawNewLine()
                .drawTriangle1Lvl2(size)
                .drawNewLine()
                .drawTriangle2Lvl1(size)
                .drawNewLine()
                .drawTriangle2Lvl2(size)
                .drawNewLine()
                .drawCrossLvl2(size)
                .drawNewLine();

        // Drawing a house using all 4 levels of abstraction, starting from the most non-optimized
        HouseDrawerService.newInstance()
                .drawHouseLvl1(size)
                .drawNewLine()
                .drawHouseLvl2(size)
                .drawNewLine()
                .drawHouseLvl3(size)
                .drawNewLine()
                .drawHouseLvl4(size)
                .drawNewLine();
    }
}
