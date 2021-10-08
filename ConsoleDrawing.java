import java.util.Scanner;

public class ConsoleDrawing
{
    private static final Scanner usertype = new Scanner(System.in);  // scanner for user typing
    private static int sl;  // user inputted side length of the shape
    private static char pc;  // user inputted printing character of the shape
    private static String ag;  // user inputted alignment of the shape


    // show menu
    public static void menu()
    {
        System.out.println("Please select an option. Type 4 to exit.");
        System.out.println("1. Draw triangles");
        System.out.println("2. Draw squares");
        System.out.println("3. Update drawing canvas settings");
        System.out.println("4. Exit");
    }


    // function - draw triangles
    public static boolean DrawTriangle(DrawingCanvas aCanvas)
    {
        Triangle newTriangle = new Triangle(sl, pc, ag);  // initialise a Triangle class
        newTriangle.DrawingTriangle(aCanvas);  // draw a triangle
        aCanvas.ShowCanvas();  // show the drawn triangle on the canvas

        char rotation_opt;  // user's rotation option
        // rotation
        do
        {
            System.out.println("Type R/L to rotate clockwise/anti-clockwise. " +
                    "Use other keys to continue.");
            rotation_opt = usertype.next().charAt(0);
            newTriangle.RotateTriangle(aCanvas, rotation_opt);  //  execute rotation
            if (rotation_opt == 'R' || rotation_opt == 'r' || rotation_opt == 'L' || rotation_opt == 'l')
                aCanvas.ShowCanvas();
        }while (rotation_opt == 'R' || rotation_opt == 'r' || rotation_opt == 'L' || rotation_opt == 'l');

        // ask whether to draw a same shape
        do
        {
            System.out.println("Draw another triangle (Y/N)?");
            rotation_opt = usertype.next().charAt(0);
            if (rotation_opt == 'Y' || rotation_opt == 'y')
                return true;
            else if (rotation_opt == 'N' || rotation_opt == 'n')
                return false;
            else
                System.out.println("Unsupported option. Please try again!");
        }while (true);
    }


    // function - draw squares
    public static boolean DrawSquare(DrawingCanvas aCanvas)
    {
        Square newSquare = new Square(sl, pc, ag);  // initialise a Square class
        newSquare.DrawingSquare(aCanvas);  // draw a square
        aCanvas.ShowCanvas();  // show the drawn square on the canvas

        char zoom_opt;  // user's zooming option
        // zooming
        do
        {
            System.out.println("Type I/O to zoom in/out. " +
                    "Use other keys to continue.");
            zoom_opt = usertype.next().charAt(0);
            newSquare.ZoomSquare(aCanvas, zoom_opt);  // execute zooming
            if (zoom_opt == 'I' || zoom_opt == 'i' || zoom_opt == 'O' || zoom_opt == 'o')
                aCanvas.ShowCanvas();
        }while (zoom_opt == 'I' || zoom_opt == 'i' || zoom_opt == 'O' || zoom_opt == 'o');

        // ask whether to draw a same shape
        do
        {
            System.out.println("Draw another square (Y/N)?");
            zoom_opt = usertype.next().charAt(0);
            if (zoom_opt == 'Y' || zoom_opt == 'y')
                return true;
            else if (zoom_opt == 'N' || zoom_opt == 'n')
                return false;
            else
                System.out.println("Unsupported option. Please try again!");
        }while (true);
    }


    public static void main(String[] args)
    {
        // initialise canvas with input values
        DrawingCanvas newDrawingCanvas = new DrawingCanvas(Integer.parseInt(args[0]),
                                                            Integer.parseInt(args[1]),
                                                            args[2].charAt(0));
        newDrawingCanvas.CreateCanvas();  // create a canvas

        int opt = 0;  // user's option
        while(opt != 4)
        {
            // show menu and user makes choice
            ConsoleDrawing.menu();
            opt = usertype.nextInt();

            boolean draw_SameShape = true;  // draw a same shape or not

            switch (opt)
            {
                case 1:  // Draw triangles
                    while(draw_SameShape)
                    {
                        do
                        {
                            System.out.println("Side length:");
                            sl = usertype.nextInt();
                            if (sl> newDrawingCanvas.getWidth() || sl> newDrawingCanvas.getHeight())
                                System.out.println("Error! The side length is too long "
                                        + "(Current canvas size is " + newDrawingCanvas.getWidth()
                                        + "x" + newDrawingCanvas.getHeight() + "). "
                                        + "Please try again.");
                        }while (sl>newDrawingCanvas.getWidth() || sl>newDrawingCanvas.getHeight());

                        System.out.println("Printing character:");
                        pc = usertype.next().charAt(0);

                        System.out.println("Alignment (left, middle, right):");
                        usertype.nextLine();
                        ag = usertype.nextLine();

                        // draw a triangle
                        draw_SameShape = ConsoleDrawing.DrawTriangle(newDrawingCanvas);
                    }
                    break;

                case 2:  // Draw squares
                    while(draw_SameShape)
                    {
                        do
                        {
                            System.out.println("Side length:");
                            sl = usertype.nextInt();
                            if (sl>newDrawingCanvas.getWidth() || sl>newDrawingCanvas.getHeight())
                                System.out.println("Error! The side length is too long "
                                        + "(Current canvas size is " + newDrawingCanvas.getWidth()
                                        + "x" + newDrawingCanvas.getHeight() + "). "
                                        + "Please try again.");
                        }while (sl>newDrawingCanvas.getWidth() || sl>newDrawingCanvas.getHeight());

                        System.out.println("Printing character:");
                        pc = usertype.next().charAt(0);

                        System.out.println("Alignment (left, middle, right):");
                        usertype.nextLine();
                        ag = usertype.nextLine();

                        // draw a square
                        draw_SameShape = ConsoleDrawing.DrawSquare(newDrawingCanvas);
                    }
                    break;

                case 3:  // Update drawing canvas settings
                    System.out.print("Canvas width: ");
                    int newWidth = usertype.nextInt();

                    System.out.print("Canvas height: ");
                    int newHeight = usertype.nextInt();

                    System.out.print("Background character: ");
                    char newBgChr = usertype.next().charAt(0);

                    newDrawingCanvas.UpdateCanvas(newWidth,newHeight,newBgChr);
                    newDrawingCanvas.ShowCanvasSize();
                    break;

                case 4:  // Exit
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Unsupported option. Please try again!");
            }
        }
    }
}
