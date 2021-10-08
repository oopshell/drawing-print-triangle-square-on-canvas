public class Square
{
    private int sidelen;  // side length
    private char printchr;  // printing character
    private String alignment;  // alignment


    // Constructor
    public Square(int aSideLen, char aPrintChr, String aAlignment)
    {
        sidelen = aSideLen;
        printchr = aPrintChr;
        alignment = aAlignment.toLowerCase();
    }


    // draw a square
    public void DrawingSquare(DrawingCanvas aCanvas)
    {
        aCanvas.ClearCanvas();
        switch (alignment)
        {
            case "middle":
                for (int i = 0; i < sidelen; i++)
                    for (int j = 0; j < sidelen; j++)
                        aCanvas.theCanvas[i][j + (aCanvas.theCanvas[0].length - sidelen)/2] = printchr;
                break;

            case "right":
                for (int i = 0; i < sidelen; i++)
                    for (int j = 0; j < sidelen; j++)
                        aCanvas.theCanvas[i][j + aCanvas.theCanvas[0].length - sidelen] = printchr;
                break;

            case "left":

            default:
                for (int i = 0; i < sidelen; i++)
                    for (int j = 0; j < sidelen; j++)
                        aCanvas.theCanvas[i][j] = printchr;
        }
    }


    // zoom the drawn square
    public void ZoomSquare(DrawingCanvas aCanvas, char aIoO)
    {
        // zoom in one character
        if (aIoO == 'I' || aIoO == 'i')
        {
            if (sidelen+1 > aCanvas.theCanvas.length
                    || sidelen+1 > aCanvas.theCanvas[0].length
                    || sidelen+1 <= 1)
                return;
            sidelen = sidelen + 1;
            aCanvas.ClearCanvas();
            DrawingSquare(aCanvas);
        }

        // zoom out one character
        else if (aIoO == 'O' || aIoO == 'o')
        {
            if (sidelen-1 > aCanvas.theCanvas.length
                    || sidelen-1 > aCanvas.theCanvas[0].length
                    || sidelen-1 < 1)
                return;
            sidelen = sidelen - 1;
            aCanvas.ClearCanvas();
            DrawingSquare(aCanvas);
        }
    }

}
