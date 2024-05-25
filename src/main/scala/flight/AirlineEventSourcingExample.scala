package flight

import flight.event.{Event, FlightDeparted, FlightScheduled, PassengerCheckedIn}
import flight.implicits._

object AirlineEventSourcingExample extends App {
  // take into account the ordering of events, adding a timestamp, and ordering in the events window before apply
  val flightScheduledEvents = Seq(
    FlightScheduled("KL1000", "AMS", "LAX", 1651783200),
    FlightScheduled("KL1001", "AMS", "CDG", 1651793200),
  )

  val passengerCheckedInEvents = Seq(
    PassengerCheckedIn("KL1000", "Mike", "10A"),
    PassengerCheckedIn("KL1000", "John", "10C"),
    PassengerCheckedIn("KL1000", "Anna", "10D"),

    PassengerCheckedIn("KL1001", "James", "11D"),
    PassengerCheckedIn("KL1001", "Emily", "11E"),
  )

  val flightDepartedEvents = Seq(
    FlightDeparted("KL1000", 1651884200),
    FlightDeparted("KL1001", 1651885200)
  )

  val flights = ApplyEvents.applyEvents(
    ApplyEvents.applyEvents(
      ApplyEvents.applyEvents(Seq(), flightScheduledEvents),
      passengerCheckedInEvents
    ),
    flightDepartedEvents
  )

  flights.foreach(println)
}
