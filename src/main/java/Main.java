import domain.Turnstile;

public class Main {
    public static void main(String[] args) {
        Turnstile turnstile = new Turnstile();
        System.out.println(turnstile.getState());
        System.out.println(turnstile.putCoin());
        System.out.println(turnstile.getState());
        System.out.println(turnstile.putCoin());
        System.out.println(turnstile.canPass());
        System.out.println(turnstile.getState());
        System.out.println(turnstile.canPass());
        turnstile.key();
        System.out.println(turnstile.putCoin());
        System.out.println(turnstile.getState());
        System.out.println(turnstile.canPass());
        System.out.println(turnstile.canPass());
        System.out.println(turnstile.getState());
        turnstile.key();
        System.out.println(turnstile.getState());
    }
}
