package com.springs.rest_demo.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.Id
import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import org.springframework.data.redis.core.RedisHash
import java.time.Instant


@Data
@NoArgsConstructor
@AllArgsConstructor
@RedisHash
@JsonIgnoreProperties(ignoreUnknown = true)
class Aircraft {
    @Id
    private var id: Long? = null
    private var callsign: String? = null
    private var squawk: String? = null
    var reg: String? = null
    private var flightno: String? = null
    private var route: String? = null
    private var type: String? = null
    private var category: String? = null
    private var altitude = 0
    private var heading = 0
    private var speed = 0

    @JsonProperty("vert_rate")
    private var vertRate = 0

    @JsonProperty("selected_altitude")
    private var selectedAltitude = 0
    private var lat = 0.0
    private var lon = 0.0
    private var barometer = 0.0

    @JsonProperty("polar_distance")
    private var polarDistance = 0.0

    @JsonProperty("polar_bearing")
    private var polarBearing = 0.0

    @JsonProperty("is_adsb")
    private var isADSB = false

    @JsonProperty("is_on_ground")
    private var isOnGround = false

    @JsonProperty("last_seen_time")
    private var lastSeenTime: Instant? = null

    @JsonProperty("pos_update_time")
    private var posUpdateTime: Instant? = null

    @JsonProperty("bds40_seen_time")
    private var bds40SeenTime: Instant? = null
}