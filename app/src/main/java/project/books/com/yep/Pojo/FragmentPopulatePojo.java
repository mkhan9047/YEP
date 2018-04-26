package project.books.com.yep.Pojo;

import java.io.Serializable;

/**
 * Created by Mujahid on 4/26/2018.
 */

public class FragmentPopulatePojo implements Serializable {
  private String title;
   private int image;

    public FragmentPopulatePojo(String title, int image) {
        this.title = title;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public int getImage() {
        return image;
    }
}
