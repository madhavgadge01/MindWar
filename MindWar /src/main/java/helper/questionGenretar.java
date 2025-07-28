package helper;

import java.util.ArrayList;
import java.util.List;

public class questionGenretar {
    public static List<quetion> getQuetions() {
        List<quetion> list = new ArrayList<>();

        list.add(new quetion(
                1,
                "Who was the first woman Prime Minister of India?",
                "Pratibha Patil", "Sarojini Naidu", "Indira Gandhi", "Sushma Swaraj",
                "Indira Gandhi"
        ));

        list.add(new quetion(
                2,
                "Which is the longest river in the world?",
                "Amazon", "Nile", "Yangtze", "Ganga",
                "Nile"
        ));

        list.add(new quetion(
                3,
                "Who wrote the Indian National Anthem 'Jana Gana Mana'?",
                "Bankim Chandra Chatterjee", "Sarojini Naidu", "Rabindranath Tagore", "Mahatma Gandhi",
                "Rabindranath Tagore"
        ));

        list.add(new quetion(
                4,
                "What is the chemical symbol of Gold?",
                "Go", "Gd", "Ag", "Au",
                "Au"
        ));

        list.add(new quetion(
                5,
                "Which planet is known as the 'Red Planet'?",
                "Venus", "Mars", "Jupiter", "Mercury",
                "Mars"
        ));

        list.add(new quetion(
                6,
                "Who is known as the 'Missile Man of India'?",
                "Vikram Sarabhai", "A. P. J. Abdul Kalam", "Homi Bhabha", "Rakesh Sharma",
                "A. P. J. Abdul Kalam"
        ));

        list.add(new quetion(
                7,
                "In which year did India gain independence?",
                "1950", "1945", "1947", "1949",
                "1947"
        ));

        list.add(new quetion(
                8,
                "Who discovered gravity?",
                "Albert Einstein", "Isaac Newton", "Galileo Galilei", "Thomas Edison",
                "Isaac Newton"
        ));

        list.add(new quetion(
                9,
                "Which is the largest desert in the world?",
                "Gobi Desert", "Sahara Desert", "Arabian Desert", "Antarctic Desert",
                "Antarctic Desert"
        ));

        list.add(new quetion(
                10,
                "Which country gifted the Statue of Liberty to the USA?",
                "England", "Germany", "Canada", "France",
                "France"
        ));


        return list;
    }
}