package flight.event

case class FlightDeparted(flightId: String, departureTime: Long) extends Event
