package pojo;

public class SubmitRecomendationPojo {
	String sessiontoken, symbol, recomendationtype, recomendationdetails;

	public String getSessiontoken() {
		return sessiontoken;
	}

	public void setSessiontoken(String sessiontoken) {
		this.sessiontoken = sessiontoken;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getRecomendationtype() {
		return recomendationtype;
	}

	public void setRecomendationtype(String recomendationtype) {
		this.recomendationtype = recomendationtype;
	}

	public String getRecomendationdetails() {
		return recomendationdetails;
	}

	public void setRecomendationdetails(String recomendationdetails) {
		this.recomendationdetails = recomendationdetails;
	}

	public SubmitRecomendationPojo(String sessiontoken, String symbol, String recomendationtype,
			String recomendationdetails) {
		super();
		this.sessiontoken = sessiontoken;
		this.symbol = symbol;
		this.recomendationtype = recomendationtype;
		this.recomendationdetails = recomendationdetails;
	}

}
