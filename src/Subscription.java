public class Subscription {
    protected String id;
    protected String title;
    protected float monthlyPrice;
    protected int startDate;
    protected  boolean active;

    public Subscription(String id, String title, float monthlyPrice, int startDate, boolean active) {
        this.id = id;
        this.title = title;
        this.monthlyPrice = monthlyPrice;
        this.startDate = startDate;
        this.active = false;
    }
    public boolean activate(int startDate, boolean active){
        if (startDate < 0 || startDate > 30) {
            System.err.println("Введите корректную дату активации подписки");
            active = false;
            return false;
        }
        System.out.println("Дата начала подписки " + startDate);
        active = true;
        return true;
    }
    public void cancel(){
        System.out.println("Подписка приостановлена");
        active = false;
    }

    public void price(float monthlyPrice) {
        System.out.println("Стоимость подписки " + monthlyPrice);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getMonthlyPrice() {
        return monthlyPrice;
    }

    public void setMonthlyPrice(float monthlyPrice) {
        this.monthlyPrice = monthlyPrice;
    }

    public int getStartDate() {
        return startDate;
    }

    public void setStartDate(int startDate) {
        this.startDate = startDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
