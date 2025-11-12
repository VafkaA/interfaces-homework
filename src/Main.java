//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        MusicPlan music = new MusicPlan("01", "Моя музыка", 600, 25, true, 3,5,14);
        music.active = true;
        System.out.println(music.monthlyCharge(5));

        CloudPlan cloud = new CloudPlan("065", "Мое облако", 541, 5, true, 6, 122, 300);
        cloud.active = true;
        System.out.println(cloud.monthlyCharge(6));

        VideoPlan video = new VideoPlan("0165", "Моя музыка", 175,24,true,5,new String[]{"Петя", "Misha", "Sasha", "Stas", "Gosha"}, new PauseWindow[5],1);
        video.active = true;
        System.out.println(video.monthlyCharge(6));
    }
}