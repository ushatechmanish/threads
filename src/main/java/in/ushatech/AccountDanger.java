package in.ushatech;

public class AccountDanger implements Runnable {
    private Account account = new Account();

    public static void main(String[] args) {
        AccountDanger danger = new AccountDanger();
        Thread one = new Thread(danger, "one");
        Thread two = new Thread(danger, "two");
        one.start();
        two.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            makeWithdrawl(10);
            if (account.getBalance() < 0) {
                System.out.println("Account is overdrawn");
            }
        }
    }

    private synchronized void makeWithdrawl(int amount) {
        if (account.getBalance() >= 10) {
            System.out.println("Amount withdraw initiated by : " + Thread.currentThread().getName());

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            account.withdraw(amount);
            System.out.println("Amount withdraw completed by : " + Thread.currentThread().getName());
        }

        System.out.println("Amount not sufficient for : " + Thread.currentThread().getName() + "account balance is "
                + account.getBalance());
    }
}
