package flight

case class Flight(flightId: String,
                  origin: String,
                  destination: String,
                  departureTime: Long,
                  passengers: Set[Passenger] = Set.empty,
                  departed: Boolean = false)
