package edu.uclm.esi.ds.games.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class Match {
	private String id;
	private Boolean ready;
	private ArrayList<String> players;
	private HashMap<String, Board> boards;
	
	public Match() {
		this.id = UUID.randomUUID().toString();	
		this.players = new ArrayList();
		this.boards = new HashMap<>();
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setReady(Boolean ready) {
		this.ready = ready;
		this.buildBoards();
	}

	private void buildBoards() {
		Board board = new Board();
		this.boards.put(this.players.get(0), board);
		this.boards.put(this.players.get(0), board.copy());
	}

	public boolean isReady() {
		return this.ready;
	}

	public void addPlayer(String player) {
		this.players.add(player);
		if (this.players.size()==2)
			this.setReady(true);
	}
	
	public List<String> getPlayers(){
		return this.players;
	}
	
	public List<Board> getBoards() {
		return boards.values().stream().toList();
	}
		
}
