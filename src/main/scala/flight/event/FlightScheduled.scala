package flight.event

case class FlightScheduled(flightId: String, origin: String, destination: String, departureTime: Long) extends Event
