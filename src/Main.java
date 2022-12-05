public class Main{

    public static void main(String[] args) {
        System.out.println("Hello world!");

        click click = new click();
        launch(click);


    }



    public static void launch(click click) {

        gui gui = new gui(click);

        click.autoclick(gui);
        gui.setMarket(click);
        System.out.println("CPS " + click.CPS + "  /// finger " + click.FPS);

        gui.launch();
    }




}