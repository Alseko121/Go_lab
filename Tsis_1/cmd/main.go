package main

import (
	"Tsis_1/handlers"
	"github.com/gorilla/mux"
	"log"
	"net/http"
)

func main() {
	r := mux.NewRouter()

	r.HandleFunc("/health-check", handlers.HealthCheck).Methods("GET")
	r.HandleFunc("/players", handlers.GetPlayers).Methods("GET")
	r.HandleFunc("/players/{name}", handlers.GetPlayerByName).Methods("GET")

	log.Println("Server started on port 8080")
	log.Fatal(http.ListenAndServe(":8080", r))
}
