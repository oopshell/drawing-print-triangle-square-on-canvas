public class Triangle
{
    private int sidelen;  // side length
    private char printchr;  // printing character
    private String alignment;  // alignment


    // Constructor
    public Triangle(int aSideLen, char aPrintChr, String aAlignment)
    {
        sidelen = aSideLen;
        printchr = aPrintChr;
        alignment = aAlignment.toLowerCase();
    }


    // draw a triangle
    public void DrawingTriangle(DrawingCanvas aCanvas)
    {
        aCanvas.ClearCanvas();
        switch (alignment)
        {
            case "middle":
                for (int i = 0; i < sidelen; i++)
                    for (int j = 0; j < sidelen-i; j++)
                        aCanvas.theCanvas[i][j + (aCanvas.theCanvas[0].length - sidelen)/2] = printchr;
                break;

            case "right":
                for (int i = 0; i < sidelen; i++)
                    for (int j = 0; j < sidelen-i; j++)
                        aCanvas.theCanvas[i][j + aCanvas.theCanvas[0].length - sidelen] = printchr;
                break;

            case "left":

            default:
                for (int i = 0; i < sidelen; i++)
                    for (int j = 0; j < sidelen-i; j++)
                        aCanvas.theCanvas[i][j] = printchr;
        }
    }


    // rotate the drawn triangle
    public void RotateTriangle(DrawingCanvas aCanvas, char aRoL)
    {
        // make a copy of the current triangle used for rotating operation
        char[][] tmp = new char[aCanvas.theCanvas.length][aCanvas.theCanvas[0].length];
        for (int i = 0; i < aCanvas.theCanvas.length; i++)
            System.arraycopy(aCanvas.theCanvas[i], 0, tmp[i], 0, aCanvas.theCanvas[0].length);
        aCanvas.ClearCanvas();

        // 90 degree clockwise rotation
        if (aRoL == 'R' || aRoL == 'r')
        {
            switch (alignment)
            {
                case "middle":
                    for (int i = 0; i < sidelen; i++)
                        for (int j = 0; j < sidelen; j++)
                            aCanvas.theCanvas[j][sidelen-i-1 + (aCanvas.theCanvas[0].length - sidelen)/2]
                                    = tmp[i][j + (aCanvas.theCanvas[0].length - sidelen)/2];
                    break;

                case "right":
                    for (int i = 0; i < sidelen; i++)
                        for (int j = 0; j < sidelen; j++)
                            aCanvas.theCanvas[j][sidelen-i-1 + aCanvas.theCanvas[0].length - sidelen]
                                    = tmp[i][j + aCanvas.theCanvas[0].length - sidelen];
                    break;

                case "left":

                default:
                    for (int i = 0; i < sidelen; i++)
                        for (int j = 0; j < sidelen; j++)
                            aCanvas.theCanvas[j][sidelen-i-1] = tmp[i][j];
            }
        }

        // 90 degree anti-clockwise rotation
        else if (aRoL == 'L' || aRoL == 'l')
        {
            switch (alignment)
            {
                case "middle":
                    for (int i = 0; i < sidelen; i++)
                        for (int j = 0; j < sidelen; j++)
                            aCanvas.theCanvas[sidelen-j-1][i + (aCanvas.theCanvas[0].length - sidelen)/2]
                                    = tmp[i][j + (aCanvas.theCanvas[0].length - sidelen)/2];
                    break;

                case "right":
                    for (int i = 0; i < sidelen; i++)
                        for (int j = 0; j < sidelen; j++)
                            aCanvas.theCanvas[sidelen-j-1][i + aCanvas.theCanvas[0].length - sidelen]
                                    = tmp[i][j + aCanvas.theCanvas[0].length - sidelen];
                    break;

                case "left":

                default:
                    for (int i = 0; i < sidelen; i++)
                        for (int j = 0; j < sidelen; j++)
                            aCanvas.theCanvas[sidelen-j-1][i] = tmp[i][j];
            }
        }
    }

}
