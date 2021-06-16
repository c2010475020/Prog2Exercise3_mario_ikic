package at.ac.fhcampuswien.newsanalyzer.ui;


import at.ac.fhcampuswien.newsanalyzer.ctrl.Controller;
import at.ac.fhcampuswien.newsapi.NewsApi;
import at.ac.fhcampuswien.newsapi.NewsApiBuilder;
import at.ac.fhcampuswien.newsapi.NewsApiException;
import at.ac.fhcampuswien.newsapi.enums.Category;
import at.ac.fhcampuswien.newsapi.enums.Country;
import at.ac.fhcampuswien.newsapi.enums.Endpoint;
import at.ac.fhcampuswien.newsapi.enums.SortBy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInterface 
{
	private Controller ctrl = new Controller();
	public static final String APIKEY = "d3d2aea7c1df4a6fb99c2d060372d54b";

	public void getDataFromCtrl1() {
		System.out.println("Euro 2020 news");

		NewsApi newsApi = new NewsApiBuilder()
				.setApiKey(APIKEY)
				.setQ("sport")
				.setEndPoint(Endpoint.TOP_HEADLINES)
				.setSourceCountry(Country.de)
				.setSourceCategory(Category.sports)
				.createNewsApi();

		ctrl.process(newsApi);
	}

	public void getDataFromCtrl2() {
		// TODO implement me
		System.out.println("NBA News");

		NewsApi newsApi = new NewsApiBuilder()
				.setApiKey(APIKEY)
				.setQ("NBA ")
				.setEndPoint(Endpoint.TOP_HEADLINES)
				.setSourceCountry(Country.us)
				.setSourceCategory(Category.science)
				.createNewsApi();

		ctrl.process(newsApi);
	}

	public void getDataFromCtrl3(){
		// TODO implement me
		System.out.println("Corona News");

		NewsApi newsApi = new NewsApiBuilder()
				.setApiKey(APIKEY)
				.setQ("corona")
				.setEndPoint(Endpoint.TOP_HEADLINES)
				.setSourceCountry(Country.gb)
				.setSourceCategory(Category.science)
				.setSortBy(SortBy.RELEVANCY)
				.createNewsApi();

		ctrl.process(newsApi);
	}
	
	public void getDataForCustomInput() {
		// TODO implement me
		System.out.println("Choice User Input");

		NewsApi newsApi = new NewsApiBuilder()
				.setApiKey(APIKEY)
				.setQ("science")
				.setEndPoint(Endpoint.TOP_HEADLINES)
				.setSourceCountry(Country.hu)
				.setSourceCategory(Category.science)
				.createNewsApi();

		ctrl.process(newsApi);
	}


	public void start() {
		Menu<Runnable> menu = new Menu<>("User Interface");
		menu.setTitle("Wählen Sie aus:");
		menu.insert("a", "Euro 2021 NEWS", this::getDataFromCtrl1);
		menu.insert("b", "NBA NEWS", this::getDataFromCtrl2);
		menu.insert("c", "Corona", this::getDataFromCtrl3);
		menu.insert("d", "Choice User Input:",this::getDataForCustomInput);
		menu.insert("q", "Quit", null);
		Runnable choice;
		while ((choice = menu.exec()) != null) {
			 choice.run();
		}
		System.out.println("Program finished");
	}


    protected String readLine() {
		String value = "\0";
		BufferedReader inReader = new BufferedReader(new InputStreamReader(System.in));
		try {
			value = inReader.readLine();
        } catch (IOException ignored) {
		}
		return value.trim();
	}

	protected Double readDouble(int lowerlimit, int upperlimit) 	{
		Double number = null;
        while (number == null) {
			String str = this.readLine();
			try {
				number = Double.parseDouble(str);
            } catch (NumberFormatException e) {
                number = null;
				System.out.println("Please enter a valid number:");
				continue;
			}
            if (number < lowerlimit) {
				System.out.println("Please enter a higher number:");
                number = null;
            } else if (number > upperlimit) {
				System.out.println("Please enter a lower number:");
                number = null;
			}
		}
		return number;
	}
}
