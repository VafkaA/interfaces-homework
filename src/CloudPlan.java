public class CloudPlan extends Subscription implements Billable{
    int storageTb;
    int baseTbPrice;
    int extraTbPrice;

    public CloudPlan(String id, String title, float monthlyPrice, int startDate, boolean active, int storageTb, int baseTbPrice, int extraTbPrice) {
        super(id, title, monthlyPrice, startDate, active);
        this.storageTb = storageTb;
        this.baseTbPrice = baseTbPrice;
        this.extraTbPrice = extraTbPrice;
    }

    @Override
    public float monthlyCharge(float storageTb) {
        if (!active) return 0;
        float totalPrice = monthlyPrice;
        if (storageTb > baseTbPrice) {
            totalPrice = (storageTb - 1) * extraTbPrice + baseTbPrice;
        }
        return totalPrice;
    }
}
