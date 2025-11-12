public interface Billable {
    //расчет списания за месяц (с учётом статуса/скидок)
    float monthlyCharge(float forMonth);
}
