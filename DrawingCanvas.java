public class DrawingCanvas
{
    private int width;  // canvas width
    private int height;  // canvas height
    private char bgChar;  // background character
    public char[][] theCanvas;  // canvas content


    // Constructor
    public DrawingCanvas(int aWidth, int aHeight, char aBgChar)
    {
        width = aWidth;
        height = aHeight;
        bgChar = aBgChar;

        System.out.println("----WELCOME TO MY CONSOLE DRAWING APP----");
        ShowCanvasSize();
    }


    // Accessor //get
    public int getWidth()
    {
        return width;
    }
    public int getHeight()
    {
        return height;
    }

    // Mutator //set


    // create the canvas with input values
    public void CreateCanvas()
    {
        theCanvas = new char[height][width];
        for (int i = 0; i < height; i++)
        {
            for (int j = 0; j < width; j++)
            {
                theCanvas[i][j] = bgChar;
            }
        }
    }

    // show the size of current canvas
    public void ShowCanvasSize()
    {
        System.out.println("Current drawing canvas settings:");
        System.out.println("- Width: " + width);
        System.out.println("- Height: " + height);
        System.out.println("- Background character: " + bgChar);
        System.out.print('\n');
    }

    // show the content of current canvas
    public void ShowCanvas()
    {
        for (int i = 0; i < height; i++)
        {
            for (int j = 0; j < width; j++)
            {
                System.out.print(theCanvas[i][j]);
            }
            System.out.print('\n');
        }
    }

    // update the canvas with new settings
    public void UpdateCanvas(int newWidth, int newHeight, char newBgChar)
    {
        width = newWidth;
        height = newHeight;
        bgChar = newBgChar;

        CreateCanvas();

        System.out.println("Drawing canvas has been updated!");
        System.out.print('\n');
    }

    // clear the canvas
    public void ClearCanvas()
    {
        for (int i = 0; i < height; i++)
            for (int j = 0; j < width; j++)
                theCanvas[i][j] = bgChar;
    }

}
