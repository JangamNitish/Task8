package pojo;

public class ViewRecomendationsPojo {
	String  stocksymbol, recomendationtype, recomendationdetails;

	public String getStocksymbol() {
		return stocksymbol;
	}

	public void setStocksymbol(String stocksymbol) {
		this.stocksymbol = stocksymbol;
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

	public ViewRecomendationsPojo(String stocksymbol, String recomendationtype, String recomendationdetails) {
		super();
		this.stocksymbol = stocksymbol;
		this.recomendationtype = recomendationtype;
		this.recomendationdetails = recomendationdetails;
	}

	public ViewRecomendationsPojo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
