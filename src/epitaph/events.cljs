(ns epitaph.events)

(def event-info
  {;; early flavor events

   :pets
   {:name :pets
    :desc ["The $CIV have domesticated a species of small $ADJ $ANIMALS. The pets "
           "assist their $CIV owners with $TASK in exchange for food and shelter."]
    :vocab {"$ADJ" ["flying" "feathered" "fluffy" "furry" "scaly" "winged"]
            "$ANIMALS" ["animals" "creatures" "predators"]
            "$TASK" ["hunting" "navigation" "pest control"]}}

   :large-city
   {:name :large-city
    :event-chances {:city-fortress (/ +3 1000)
                    :city-holy (/ +3 1000)
                    :city-trade (/ +3 1000)}
    :desc ["In $STARDATE, the $CIV population reached 25 million individuals. "
           "Many of these $LIVE within permanent cities, the largest of which "
           "is known as $CITY and has a population of $POP,000."]
    :vocab {"$LIVE" ["dwell" "live" "reside"]
            "$POP" #(+ 15 (rand-int 80))}}

   :conqueror
   {:name :conqueror
    :event-chances {:city-fortress (/ +10 1000)}
    :desc ["In $STARDATE, many of the $ADJ $CIV $CLANS were united under a "
           "single banner by an individual known as $CONQUEROR. $NEW_EMPIRE "
           "rules over approximately $PERCENT% of the entire $CIV population. "
           "$AS_USUAL, it is governed by $GOV."]
    :vocab {"$ADJ" ["disparate" "fractious" "warring"]
            "$CLANS" ["city-states" "clans" "kingdoms" "tribes" "villages"]
            "$NEW_EMPIRE" ["The resulting empire has its capital at $CITY and"
                           "The city of $CITY $WAS_MADE the capital of the resulting empire, which"]
            "$WAS_MADE" ["has become" "has been declared" "has been made" "has been named"]
            "$PERCENT" #(+ 5 (rand-int 40))
            "$AS_USUAL" ["Like many other $CIV states" "Unusually for the $CIV"]
            "$GOV" ["a council of $LEADERS" "a hereditary monarch"
                    "an elected tyrant" "direct democratic vote"]
            "$LEADERS" ["aristocrats" "clerics" "elders" "oligarchs" "war leaders"]}}

   :religion
   {:name :religion
    :event-chances {:city-holy (/ +10 1000)}
    :desc ["In $STARDATE, $A_NEW religion known as $RELIGION $BECAME the "
           "official religion of the largest $CIV state. Adherents of $RELIGION "
           "wear $ADJ1 $THINGS to mark themselves as believers."]
    :vocab {"$A_NEW" ["a rapidly growing" "an emerging"]
            "$BECAME" ["became" "was declared"]
            "$ADJ1" ["$DISTINCTIVE $ADJ2" "$PLAIN $ADJ3" "$ADJ4"]
            "$THINGS" ["caps" "cloaks" "clothes" "clothing" "coats" "fabrics"
                       "hats" "hoods" "masks" "robes" "shawls"]
            "$DISTINCTIVE" ["distinctive" "striking"]
            "$ADJ2" ["beaded" "black" "blue" "brown" "dark" "embroidered" "gray"
                     "green" "patterned" "purple" "scarlet" "red" "white"]
            "$PLAIN" ["plain" "simple"]
            "$ADJ3" ["black" "blue" "brown" "dark" "gray" "green" "purple"
                     "scarlet" "red" "white"]
            "$ADJ4" ["brightly colored"
                     "$ADJ5 colorful"
                     "$ADJ6concealing"
                     "elaborately decorated"
                     "intricately patterned"]
            "$ADJ5" ["dazzlingly" "distinctive"]
            "$ADJ6" ["distinctive " ""]}}

   ;; city flavor events (mutually exclusive)

   :city-fortress
   {:name :city-fortress
    :prereqs #{:large-city}
    :event-chances {:city-holy -1
                    :city-trade -1}
    :desc ["Following a long series of failed attempts to $ATTACK the city, "
           "$CITY has become renowned among the $CIV as an impenetrable "
           "fortress. The image of its distinctive $WALLS has been widely "
           "adopted in $CIV $ART as a symbol of $SAFETY."]
    :vocab {"$ATTACK" ["attack" "besiege" "capture" "conquer"]
            "$WALLS" ["gate" "ramparts" "towers" "walls"]
            "$ART" ["art" "culture" "literature" "oratory"]
            "$SAFETY" ["resilience" "safety" "strength"]}}

   :city-holy
   {:name :city-holy
    :prereqs #{:large-city}
    :event-chances {:city-fortress -1
                    :city-trade -1}
    :desc ["Due to its role as the birthplace of several major $CIV religions, "
           "including the especially prominent $RELIGION faith, the city of "
           "$CITY is regarded by many of the $CIV as a holy site. $DETAIL"]
    :vocab {"$DETAIL" [(str "The $POPE_OF $CITY is considered the de facto "
                            "leader of the $RELIGION church as a whole, and "
                            "pilgrimages to the city are commonplace.")
                       (str "Leaders from all around the world $VISIT the "
                            "city $TO_CURRY favor with the leaders of their "
                            "people's religion of choice.")]
            "$POPE_OF" ["archbishop of" "high priest of"
                        "highest-ranking $RELIGION $OFFICIAL in"]
            "$OFFICIAL" ["bishop" "official" "priest"]
            "$VISIT" ["journey to" "make trips to" "travel to" "visit"]
            "$TO_CURRY" ["in hopes of currying" "in order to curry"]}}

   :city-trade
   {:name :city-trade
    :prereqs #{:large-city}
    :event-chances {:city-fortress -1
                    :city-holy -1}
    :desc ["The city of $CITY has become renowed among the $CIV as a center of "
           "commerce and trade. In particular, the $ADJ $STUFF_MADE_THERE_IS "
           "highly sought after by traders around the world."]
    :vocab {"$ADJ" ["delicate" "durable" "elegant" "fine" "high-quality"
                    "intricately decorated" "sturdy"]
            "$STUFF_MADE_THERE_IS"
            #(let [stuff (rand-nth
                           ["armor" "ceramics" "clothing" "fabrics" "glassware"
                            "jewelry" "pottery" "textiles" "weapons"])]
               (str stuff " produced there "
                    (if (= (last stuff) "s") "are" "is")))}}

    ;; late-game events

    :world-government
    {:name :world-government
     :event-chances {:nuclear-strike -1}
     :desc ["In $STARDATE, following decades of negotiation, the various "
            "sovereign $CIV nations came to an agreement concerning the "
            "establishment of a unified planet-wide government for all of the "
            "$CIV."]}

    :nuclear-weapons
    {:name :nuclear-weapons
     :prereqs #{:flight :nuclear-physics :rocketry}
     :event-chances {:nuclear-strike (/ +1 90)}
     :desc ["In $STARDATE, the $CIV successfully detonated their first "
            "prototype nuclear weapon. It remains unclear whether the $CIV "
            "scientists who worked on the bomb understand the sheer "
            "destructive potential of the weapon they have created."]}

    :nuclear-strike
    {:name :nuclear-strike
     :event-chances {:pets (/ +3 1000)}
     :desc ["In $STARDATE, a single nuclear weapon was deployed in an attack "
            "on a $SIZE $CIV city. The incident did not escalate into "
            "a full-scale nuclear war, but the city was almost completely "
            "obliterated, resulting in the deaths of some $POP,000 $CIV."]
     :vocab {"$SIZE" ["small" "medium-sized" "large" "major"]
             "$POP" #(+ (rand-int 200) 50)}}
