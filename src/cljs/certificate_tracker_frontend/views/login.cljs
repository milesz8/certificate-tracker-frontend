(ns certificate-tracker-frontend.views.login
  (:require
   [certificate-tracker-frontend.subs :as subs]
   [re-frame.core :as re-frame]
   [re-com.core :as re-com]
   [reagent.core :as reagent]))

(defn login-title []
  [re-com/title
   :label "Hello, this is the login Page!"
   :level :level1])

(defn link-to-families-page []
  [re-com/hyperlink-href
   :label "go to families Page"
   :href "#/"])

(defn errors-list
  [errors]
  [:ul.list-group
   (for [[key [val]] errors]
     ^{:key key} [:div.alert.alert-warning (str (name key) " " val)])])

(defn login-form []
  (let [default {:username nil :password nil}
        credentials (reagent/atom default)]
    (fn []
      (let [{:keys [username password]} @credentials
            loading @(re-frame/subscribe [:loading])
            errors @(re-frame/subscribe [:errors])
            login-user (fn [event credentials]
                         (.preventDefault event)
                         (re-frame/dispatch [:login credentials]))]
        [:div.d-flex.justify-content-md-center.align-items-center
         [:div.card.col-6.login-card
          [:span.p-3]
          [:h1.title {:stlye {:margin-left "45px"}} "Login" [:img {:style {:height "90px"} :src "/images/404.png"}]]
          [:div.card-body
           (when (:login errors)
             [errors-list (:login errors)])
           [:form {:on-submit #(login-user % @credentials)}
            [:div.form-group
             [:label {:for "username"}
              "Username"]
             [:input.form-control {:type "email"
                                   :value username
                                   :on-change #(swap! credentials assoc :username (-> % .-target .-value))
                                   :id "username"}]]
            [:div.form-group
             [:label {:for "passwordInput"}
              "Password"]
             [:input {:type "password"
                      :class "form-control"
                      :value password
                      :on-change #(swap! credentials assoc :password (-> % .-target .-value))
                      :disabled (when (:login loading))
                      :id "passwordInput"}]]
            [:button.btn.btn-primary {:role "button"
                                      :class (when (:login loading) "disabled")}
             "Submit"]]]]]))))

(defn login-body2 []
  [:div.test.test2 [:label "tests"]])

(defn login-page []
  [re-com/v-box
   :gap "1em"
   :children [[login-title]
              [link-to-families-page]
              [login-form]]])