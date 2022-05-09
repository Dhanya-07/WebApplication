
public class Member {
	private String fav_dir;
	private String fav_mov;
	private String name_p;
	private int age_p;
	private String gender_p;

	public Member() {
		super();
	}

	public Member(String name_p, int age_p, String gender_p,String fav_dir, String fav_mov) {
		super();
		this.fav_dir = fav_dir;
		this.fav_mov = fav_mov;
		this.name_p = name_p;
		this.age_p = age_p;
		this.gender_p = gender_p;
	}

	public String getFav_dir() {
		return fav_dir;
	}

	public void setFav_dir(String fav_dir) {
		this.fav_dir = fav_dir;
	}

	public String getFav_mov() {
		return fav_mov;
	}

	public void setFav_mov(String fav_mov) {
		this.fav_mov = fav_mov;
	}

	public String getName_p() {
		return name_p;
	}

	public void setName_p(String name_p) {
		this.name_p = name_p;
	}

	public int getAge_p() {
		return age_p;
	}

	public void setAge_p(int age_p) {
		this.age_p = age_p;
	}

	public String getGender_p() {
		return gender_p;
	}

	public void setGender_p(String gender_p) {
		this.gender_p = gender_p;
	}

}
