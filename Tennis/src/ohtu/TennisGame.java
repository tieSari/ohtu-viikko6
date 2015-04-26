package ohtu;

import java.util.HashMap;

public class TennisGame {

    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;
    private HashMap<Integer, String> evenTable;
    private HashMap<Integer, String> tempTable;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;

        CreateScoreTables();
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1") {
            m_score1 += 1;
        } else {
            m_score2 += 1;
        }
    }

    private void CreateScoreTables() {
        CreateEvenTable();
        CreateTempTable();
    }

    private void CreateEvenTable() {
        evenTable = new HashMap();

        evenTable.put(0, "Love-All");
        evenTable.put(1, "Fifteen-All");
        evenTable.put(2, "Thirty-All");
        evenTable.put(3, "Forty-All");
        evenTable.put(4, "Deuce");
    }

    private void CreateTempTable() {
        tempTable = new HashMap();

        tempTable.put(0, "Love");
        tempTable.put(1, "Fifteen");
        tempTable.put(2, "Thirty");
        tempTable.put(3, "Forty");
    }

    public String getScore() {
        String description;
 
        if (m_score1 == m_score2) {
            description = evenTable.get(m_score1);

        } else if (m_score1 >= 4 || m_score2 >= 4) {
            int minusResult = m_score1 - m_score2;
            if (minusResult == 1) {
                description = "Advantage player1";
            } else if (minusResult == -1) {
                description = "Advantage player2";
            } else if (minusResult >= 2) {
                description = "Win for player1";
            } else {
                description = "Win for player2";
            }
        } else {
            description = tempTable.get(m_score1);
            description += "-" + tempTable.get(m_score2);
        }
        return description;
    }
}
