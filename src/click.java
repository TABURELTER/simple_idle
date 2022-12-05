public class click extends item{
    Main Main;
    gui gui;

    click clickq;

    int Balans = 0;

    int CPS = 0;
    int FPS = 1;


    item item0 = new finger();
    item item1 = new simple_click();
    item item2 = new middle_click();
    item item3 = new top_click();



    public void autoclick(gui guiq) {
        Thread t = new Thread(new Runnable() {
            public void run() {
                while (true){
                    if (CPS != 1){
                        Balans += CPS/2;
                    }else {
                        Balans += 1;
                    }

                    guiq.updatecount(Balans);
                    System.out.println("B: " + Balans);
                    guiq.updateCPS(CPS);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

        });

        t.start();
    }



    public void addf(){
        Balans += FPS;
        System.out.println("F: " + Balans);
    }


    public void buy(int menu){
        System.out.println("Пришло "+menu);

        if(menu == 0 && Balans >= (int)item0.cost){
            System.out.println("Покупаем палец "+Balans +" и цена "+(int)item0.cost);

            Balans -= (int)item0.cost;
            item0.cost = (int)item0.cost * item0.multicost;
            FPS += item0.CPS;

        } else if (menu == 1 && Balans >= (int)item1.cost) {
            System.out.println("Покупаем low "+Balans +" и цена "+(int)item1.cost);

            Balans -= (int)item1.cost;
            item1.cost = (int)item1.cost * item1.multicost;
            CPS += item1.CPS;
        } else if (menu == 2 && Balans >= (int)item2.cost) {
            System.out.println("Покупаем middle "+Balans +" и цена "+item2.cost);

            Balans -= (int)item2.cost;
            item2.cost = (int)item2.cost * item2.multicost;
            CPS += item2.CPS;
        } else if (menu == 3 && Balans >= (int)item3.cost) {
            System.out.println("Покупаем top "+Balans +" и цена "+(int)item3.cost);

            Balans -= (int)item3.cost;
            item3.cost = (int)item3.cost * item3.multicost;
            CPS += item3.CPS;
        }
    }

}
