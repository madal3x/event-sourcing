package flight

import flight.event.{FlightDeparted, FlightScheduled, PassengerCheckedIn}

object implicits {
  implicit val flightScheduledApplier: ApplyEvent[FlightScheduled] = new ApplyEvent[FlightScheduled] {
    def applyEvent(flights: Seq[Flight], event: FlightScheduled): Seq[Flight] = {
      flights :+ Flight(event.flightId, event.origin, event.destination, event.departureTime)
    }
  }

  implicit val passengerCheckedInApplier: ApplyEvent[PassengerCheckedIn] = new ApplyEvent[PassengerCheckedIn] {
    def applyEvent(flights: Seq[Flight], event: PassengerCheckedIn): Seq[Flight] = {
      flights.map {
        case flight if flight.flightId == event.flightId =>
          flight.copy(passengers = flight.passengers + Passenger(event.passengerId, event.seatNumber))
        case flight =>
          flight
      }
    }
  }

  implicit val flightDepartedApplier: ApplyEvent[FlightDeparted] = new ApplyEvent[FlightDeparted] {
    def applyEvent(flights: Seq[Flight], event: FlightDeparted): Seq[Flight] = {
      flights.map {
        case flight if flight.flightId == event.flightId =>
          flight.copy(departed = true, departureTime = event.departureTime)
        case flight =>
          flight
      }
    }
  }
}
