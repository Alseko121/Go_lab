package handlers

import (
	"encoding/json"
	"github.com/gorilla/mux"
	"net/http"
)

type Player struct {
	Name string `json:"name"`
	Age  int    `json:"age"`
	Role string `json:"role"`
	Team string `json:"team"`
}

var players = []Player{
	{Name: "s1mple", Age: 23, Role: "AWPer", Team: "Natus Vincere"},
	{Name: "ZywOo", Age: 20, Role: "AWPer", Team: "Team Vitality"},
	{Name: "NiKo", Age: 24, Role: "Rifler", Team: "G2 Esports"},
	{Name: "m0NESY", Age: 18, Role: "AWPer", Team: "G2 Esports"},
	{Name: "ropz", Age: 21, Role: "Rifler", Team: "Faze Clan"},
	{Name: "Twistzz", Age: 21, Role: "Rifler", Team: "FaZe Clan"},
}

// healthcheck response
func HealthCheck(w http.ResponseWriter, r *http.Request) {
	w.WriteHeader(http.StatusOK)
	w.Write([]byte("CS:GO Players API is running!"))
}

// list of all players
func GetPlayers(w http.ResponseWriter, r *http.Request) {
	w.Header().Set("Content-Type", "application/json")
	json.NewEncoder(w).Encode(players)
}

// details of players name
func GetPlayerByName(w http.ResponseWriter, r *http.Request) {
	w.Header().Set("Content-Type", "application/json")

	vars := mux.Vars(r)
	name := vars["name"]

	for _, player := range players {
		if player.Name == name {
			json.NewEncoder(w).Encode(player)
			return
		}
	}

	http.Error(w, "Player not found", http.StatusNotFound)
}
