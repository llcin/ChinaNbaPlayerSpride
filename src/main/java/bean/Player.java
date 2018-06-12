package bean;

public class Player {
	private String countryEn; //u
	
	private String country;  //meiguo
	
	private String lastName; //g
	
	private String code;  
	
	private String displayAffiliation;
	
	private String displayName;
	
	private String draftYear;
	
	private String schoolType;
	
	private String weight;
	
	private String experience;
	
	private String lastNameEn;
	
	private String jerseyNo;
	
	private String firstName;
	
	private String firstNameEn;
	
	private String dob;
	
	private String leagueId;
	
	private String displayNameEn;
	
	private String position;
	
	private String firstInitial;
	
	private String height;
	
	private int playerId;
	
	private String team;
	
	
	
	public Player() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Player(String countryEn, String country, String lastName, String code, String displayAffiliation,
			String displayName, String draftYear, String schoolType, String weight, String experience,
			String lastNameEn, String jerseyNo, String firstName, String firstNameEn, String dob, String leagueId,
			String displayNameEn, String position, String firstInitial, String height, int playerId, String team) {
		super();
		this.countryEn = countryEn;
		this.country = country;
		this.lastName = lastName;
		this.code = code;
		this.displayAffiliation = displayAffiliation;
		this.displayName = displayName;
		this.draftYear = draftYear;
		this.schoolType = schoolType;
		this.weight = weight;
		this.experience = experience;
		this.lastNameEn = lastNameEn;
		this.jerseyNo = jerseyNo;
		this.firstName = firstName;
		this.firstNameEn = firstNameEn;
		this.dob = dob;
		this.leagueId = leagueId;
		this.displayNameEn = displayNameEn;
		this.position = position;
		this.firstInitial = firstInitial;
		this.height = height;
		this.playerId = playerId;
		this.team = team;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public String getCountryEn() {
		return countryEn;
	}
	public void setCountryEn(String countryEn) {
		this.countryEn = countryEn;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDisplayAffiliation() {
		return displayAffiliation;
	}
	public void setDisplayAffiliation(String displayAffiliation) {
		this.displayAffiliation = displayAffiliation;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getDraftYear() {
		return draftYear;
	}
	public void setDraftYear(String draftYear) {
		this.draftYear = draftYear;
	}
	public String getSchoolType() {
		return schoolType;
	}
	public void setSchoolType(String schoolType) {
		this.schoolType = schoolType;
	}

	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getLastNameEn() {
		return lastNameEn;
	}
	public void setLastNameEn(String lastNameEn) {
		this.lastNameEn = lastNameEn;
	}
	public String getJerseyNo() {
		return jerseyNo;
	}
	public void setJerseyNo(String jerseyNo) {
		this.jerseyNo = jerseyNo;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getFirstNameEn() {
		return firstNameEn;
	}
	public void setFirstNameEn(String firstNameEn) {
		this.firstNameEn = firstNameEn;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getLeagueId() {
		return leagueId;
	}
	public void setLeagueId(String leagueId) {
		this.leagueId = leagueId;
	}
	public String getDisplayNameEn() {
		return displayNameEn;
	}
	public void setDisplayNameEn(String displayNameEn) {
		this.displayNameEn = displayNameEn;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getFirstInitial() {
		return firstInitial;
	}
	public void setFirstInitial(String firstInitial) {
		this.firstInitial = firstInitial;
	}
	
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	@Override
	public String toString() {
		return "Player [countryEn=" + countryEn + ", country=" + country + ", lastName=" + lastName + ", code=" + code
				+ ", displayAffiliation=" + displayAffiliation + ", displayName=" + displayName + ", draftYear="
				+ draftYear + ", schoolType=" + schoolType + ", weight=" + weight + ", experience=" + experience
				+ ", lastNameEn=" + lastNameEn + ", jerseyNo=" + jerseyNo + ", firstName=" + firstName
				+ ", firstNameEn=" + firstNameEn + ", dob=" + dob + ", leagueId=" + leagueId + ", displayNameEn="
				+ displayNameEn + ", position=" + position + ", firstInitial=" + firstInitial + ", height=" + height
				+ ", playerId=" + playerId + "]";
	}
	

}
