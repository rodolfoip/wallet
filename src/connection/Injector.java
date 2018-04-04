package connection;

import control.CoinController;
import control.UserController;
import model.Coin;
import model.User;

public class Injector {

    private static Injector injector;

    public void injetarCadastros() {

        Coin real = new Coin("Real", 1);
        Coin putin = new Coin("Putin", 8.12);
        Coin doge = new Coin("Doge", 3.5);
        Coin marreta = new Coin("Marreta", 1.43);
        Coin recayd = new Coin("Recayd", 4.09);

        User marcelo = new User("mbros", "123123", "Marcelo Brosowicz de Paulo", "86454110087", CoinController.getCoinController().createWallet());
        User victor = new User("goulartvic", "1928", "Victor Pereira Goulart", "12541462964", CoinController.getCoinController().createWallet());
        User rodolfo = new User("rodolfoip", "12345", "Rodolfe Ilce Pereira", "83306016926", CoinController.getCoinController().createWallet());

        CoinController.getCoinController().create(real);
        CoinController.getCoinController().create(putin);
        CoinController.getCoinController().create(doge);
        CoinController.getCoinController().create(marreta);
        CoinController.getCoinController().create(recayd);

        UserController.getUserController().create(marcelo);
        UserController.getUserController().create(victor);
        UserController.getUserController().create(rodolfo);

        CoinController.getCoinController().depositReal(UserController.getUserController().searchUser("mbros"), 5000);
        Coin coinOut = CoinController.getCoinController().searchCoin("1");
        Coin coinIN = CoinController.getCoinController().searchCoin("3");
        CoinController.getCoinController().exchange(UserController.getUserController().searchUser("mbros"), 100, coinOut, coinIN);
        CoinController.getCoinController().withdrawReal(UserController.getUserController().searchUser("mbros"), 80);
        CoinController.getCoinController().depositReal(UserController.getUserController().searchUser("mbros"), 300);
        CoinController.getCoinController().depositReal(UserController.getUserController().searchUser("goulartvic"), 300);
        Coin coinOut1 = CoinController.getCoinController().searchCoin("1");
        Coin coinIN2 = CoinController.getCoinController().searchCoin("4");
        CoinController.getCoinController().exchange(UserController.getUserController().searchUser("goulartvic"), 100, coinOut1, coinIN2);
        CoinController.getCoinController().withdrawReal(UserController.getUserController().searchUser("goulartvic"), 80);
        CoinController.getCoinController().depositReal(UserController.getUserController().searchUser("rodolfoip"), 300);
        Coin coinOut2 = CoinController.getCoinController().searchCoin("1");
        Coin coinIN3 = CoinController.getCoinController().searchCoin("5");
        CoinController.getCoinController().exchange(UserController.getUserController().searchUser("rodolfoip"), 150, coinOut2, coinIN3);
        CoinController.getCoinController().withdrawReal(UserController.getUserController().searchUser("rodolfoip"), 90);
    }

    public static Injector getInjector() {
        if (injector == null) {
            injector = new Injector();
        }
        return injector;
    }

    public static void setInjector(Injector injector) {
        Injector.injector = injector;
    }
}