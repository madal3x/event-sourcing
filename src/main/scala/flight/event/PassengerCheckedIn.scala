package flight.event

case class PassengerCheckedIn(flightId: String, passengerId: String, seatNumber: String) extends Event

