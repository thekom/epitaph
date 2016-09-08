(ns epitaph.techs)

(def all-techs
  [{:name :toolmaking
    :event-chances {:overhunting (/ +4 1000)
                    :overfishing (/ -3 1000)
                    :crop-failure (/ -3 1000)
                    :food-illness (/ +1 1000)
                    :pets (/ +3 1000)
                    :conqueror (/ +1 1000)}
    :desc ["The $CIV use stone tools for many things, including as weapons "
           "when hunting the wild $BEAST."]}

   {:name :agriculture
    :event-chances {:overhunting (/ -3 1000)
                    :overfishing (/ -3 1000)
                    :crop-failure (/ +4 1000)
                    :pets (/ +4 1000)}
    :desc ["The $CIV have begun to cultivate crops$INCLUDING $THE_CROP."]
    :vocab {"$INCLUDING" [", including"
                          ". One especially popular crop is"
                          ". They are especially fond of"]
            "$THE_CROP" ["a kind of $ADJ $PLANT known as $CROP$DETAIL"
                         "$CROP, a kind of $ADJ $PLANT$DETAIL"]
            "$ADJ" ["bitter" "chewy" "colorful" "fleshy" "hardy" "sour" "sweet"
                    "tasty" "tough"]
            "$PLANT" ["cactus" "flower" "fruit" "fungus" "grain" "leaf" "lichen"
                      "moss" "mushroom" "nut" "root" "seaweed" "seedpod" "stalk"
                      "vegetable" "vine"]
            "$DETAIL" ["" "" " that grows well $IN_BIOME of $PLANET"]
            "$IN_BIOME" ["in the $BIOME_A" "on the $BIOME_B"]
            "$BIOME_A" ["dense forests" "deserts" "dominant climate"
                        "fertile soil" "forests" "grasslands" "jungles" "soil"
                        "rainforests" "rocky soil" "scrublands"]
            "$BIOME_B" ["floodplains" "plains" "riverbanks"]}}

   {:name :fishing
    :event-chances {:overhunting (/ -3 1000)
                    :overfishing (/ +4 1000)
                    :crop-failure (/ -3 1000)
                    :food-illness (/ +1 1000)}
    :desc ["The $CIV have learned how to catch water-dwelling creatures such "
           "as the $FISH, which is now $AN_IMPORTANT part of the $CIV diet."]
    :vocab {"$AN_IMPORTANT" ["an important" "a staple"]}}

   {:name :writing
    :event-chances {:war-over-metal (/ -1 1000)
                    :conqueror (/ +3 1000)
                    :religion (/ +1 1000)}
    :desc ["The $CIV have developed a simple system of writing, which they use "
           "primarily for $PURPOSE."]
    :vocab {"$PURPOSE" ["poetry" "record-keeping" "storytelling" "worship"]}}

   {:name :astronomy
    :event-chances {:religion (/ +1 1000)}
    :desc ["The $CIV have begun to watch the skies and recognize patterns in "
           "the movements of stars, which they use to navigate over great "
           "distances and keep track of time."]}

   {:name :fire
    :prereqs #{:toolmaking}
    :event-chances {:forest-fire (/ +2 1000)
                    :food-illness (/ -3 1000)}
    :desc ["The $CIV have mastered the control of fire. They use it to cook "
           "their food, and to light their villages at night."]}

   {:name :metalworking
    :prereqs #{:fire}
    :event-chances {:war-over-metal (/ +3 1000)
                    :conqueror (/ +4 1000)}
    :desc ["The $CIV have discovered how to forge molten metal into jewelry, "
           "tools, weapons, and armor."]}

   {:name :construction
    :prereqs #{:toolmaking :agriculture}
    :event-chances {:large-city (/ +1 1000)
                    :city-plague (/ +2 1000)
                    :war-over-metal (/ -1 1000)
                    :forest-fire (/ -2 1000)
                    :conqueror (/ +2 1000)
                    :pets (/ +1 1000)
                    :religion (/ +3 1000)}
    :desc ["The $CIV have begun to construct permanent dwellings and other "
           "structures using materials such as wood and stone."]}

   {:name :mathematics
    :prereqs #{:writing :astronomy}
    :desc ["The $CIV have developed a sophisticated understanding of basic "
           "mathematics, such as arithmetic, algebra, and geometry."]}

   {:name :sailing
    :prereqs #{:astronomy :construction :fishing}
    :event-chances {:sea-plague (/ +2 1000)
                    :large-city (/ +1 1000)
                    :war-over-metal (/ -2 1000)
                    :city-trade (/ +7 1000)}
    :desc ["The $CIV have learned how to build ships and sail them across the "
           "oceans of $PLANET to explore and trade over increasingly greater "
           "distances."]}

   {:name :architecture
    :prereqs #{:construction :mathematics}
    :event-chances {:large-city (/ +5 1000)
                    :city-fire (/ -1 1000)
                    :religion (/ +5 1000)}
    :desc ["The $CIV have begun to make use of more sophisticated construction "
           "techniques, relying on sturdy structural elements such as arches "
           "and buttresses to support larger and larger buildings."]}

   {:name :plumbing
    :prereqs #{:construction :metalworking}
    :event-chances {:large-city (/ +3 1000)
                    :city-plague (/ -2 1000)
                    :sea-plague (/ -1 1000)}
    :desc ["The $CIV have built elaborate pipe and sewer systems to supply "
           "their larger settlements, such as $CITY, with fresh water and a "
           "hygenic means of waste disposal."]}

   {:name :optics
    :prereqs #{:mathematics :metalworking}
    :desc ["The $CIV have begun to use lenses and mirrors made from polished "
           "crystal, glass, and water to redirect and focus light."]}

   {:name :alchemy
    :prereqs #{:mathematics :metalworking}
    :desc ["Some of the $CIV have begun to experiment with alchemy, "
           "systematically searching for new ways of combining and manipulating "
           "ingredients to yield useful chemicals, compounds, and medicines."]}])